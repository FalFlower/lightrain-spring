package com.spring.lightrain.controller;

import com.spring.lightrain.VO.ResultVO;
import com.spring.lightrain.converter.VideoEvaluateForm2VideoEvaluate;
import com.spring.lightrain.converter.VideoForm2Video;
import com.spring.lightrain.dataobject.UV;
import com.spring.lightrain.dataobject.Video;
import com.spring.lightrain.dataobject.VideoEvaluate;
import com.spring.lightrain.dataobject.dto.UvDTO;
import com.spring.lightrain.enums.ResultEnum;
import com.spring.lightrain.exception.RainException;
import com.spring.lightrain.form.VideoEvaluateForm;
import com.spring.lightrain.form.VideoForm;
import com.spring.lightrain.service.UVService;
import com.spring.lightrain.service.VideoEvaluateService;
import com.spring.lightrain.service.VideoService;
import com.spring.lightrain.utils.Date2LongSerializer;
import com.spring.lightrain.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    VideoService service;

    @Autowired
    VideoEvaluateService evaluateService;

    @Autowired
    UVService uvService;

    @GetMapping("info")
    public ResultVO<VideoForm> findVideo(@RequestParam("videoId") String videoId){
        return ResultVOUtil.success(VideoForm2Video.reConvert(service.findVideo(videoId)));
    }

    @GetMapping("info/all")
    public ResultVO<List<VideoForm>> findAllVideo(){
        List<VideoForm> list= new ArrayList<VideoForm>();
        for (Video video : service.findAllVideo()) {
            list.add(VideoForm2Video.reConvert(video));
        }
        return ResultVOUtil.success(list);
    }

    @PostMapping("update")
    public ResultVO<VideoForm> update(@Valid VideoForm form , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new RainException(ResultEnum.UPDATE_VIDEO_FAILED);
        }
        service.update(VideoForm2Video.convert(form));
        return ResultVOUtil.success(form);
    }

    /*
     * 用户观看视频
     * */
    @PostMapping("uv/update")
    public ResultVO<UV> getAllByUsername(@RequestParam("videoId") String videoId,
                                         @RequestParam("username") String username,
                                         @RequestParam("videoProgress") String videoProgress){
        UV uv=null;
        if (isBuy(videoId, username)){
            if (uvService.getUV(videoId,username)==null){
                //如果第一次观看，修改对应Video的学习人数
                Video video=service.findVideo(videoId);
                video.setVideoLearningNum(video.getVideoLearningNum()+1);
                service.update(video);
            }
            //更新UV表，添加/更新用户观看信息
            UvDTO uvDTO=new UvDTO();
            uvDTO.setUsername(username);
            uvDTO.setVideoId(videoId);
            int progress=Integer.parseInt(videoProgress);
            if (progress>service.findVideo(videoId).getVideoTime()){
                throw new RainException(ResultEnum.VIDEO_TIME_ERROR);
            }

            uvDTO.setVideoProgress(progress);
            uv=uvService.updateUV(uvDTO);
        }
        return ResultVOUtil.success(uv);
    }

    @GetMapping("uv/get")
    public ResultVO<UV> getUV(@RequestParam("videoId") String videoId,
                              @RequestParam("username") String username){
        return ResultVOUtil.success(uvService.getUV(videoId,username));
    }

    @GetMapping("uv/get/all/user")
    public ResultVO<List<UV>> getUVAllUser(@RequestParam("username") String username){
        return ResultVOUtil.success(uvService.getUserAllUV(username));
    }

    @GetMapping("uv/get/all/video")
    public ResultVO<List<UV>> getUVAllVideo(@RequestParam("videoId") String videoId){
        return ResultVOUtil.success(uvService.getVideoAllUV(videoId));
    }
    /**
     * 视频评分
     * */
    //更新用户对指定视频的评分，只能评价一次
    @PostMapping("evaluate/update")
    public ResultVO<VideoEvaluateForm> addVideoEvaluate(@Valid VideoEvaluateForm form,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new RainException(ResultEnum.UPDATE_VIDEO_EVALUATE_FAILED);
        }
        VideoEvaluateForm videoEvaluateForm=null;
        VideoEvaluate videoEvaluate=VideoEvaluateForm2VideoEvaluate.convert(form);
        String videoId=videoEvaluate.getVideoId(),username=videoEvaluate.getUsername();
        if (isBuy(videoId,username)){//必须先购买
            if (evaluateService.getVideoEvaluate(videoId,username)!=null){
                //评价已存在，抛出异常
                throw new RainException(ResultEnum.VIDEO_EVALUATE_EXITS);
            }
            //计算总评分，然后修改Video表
            countEvaluateAva(videoId,videoEvaluate.getVideoScore());

            videoEvaluateForm=VideoEvaluateForm2VideoEvaluate.
                    reConvert(evaluateService.updateVideoEvaluate(videoEvaluate));
        }
        return ResultVOUtil.success(videoEvaluateForm);
    }
    //计算总评分
    private void countEvaluateAva(String videoId, int videoScore) {
        Video video=service.findVideo(videoId);
        float score=0f;
        for (VideoEvaluate videoEvaluate : evaluateService.findAllEvaluateByVideoId(videoId)) {
            score+=videoEvaluate.getVideoScore();
        }
        video.setVideoScoreAva((score+videoScore)/(video.getVideoLearningNum()));//必须先观看才能再来评分
        service.update(video);
    }

    //获取指定videoId的所有用户评价
    @GetMapping("evaluate/get/video")
    public ResultVO<List<VideoEvaluateForm>> getAllByVideoId(@RequestParam("videoId") String videoId){
        List<VideoEvaluateForm> list=new ArrayList<>();
        for (VideoEvaluate videoEvaluate : evaluateService.findAllEvaluateByVideoId(videoId)) {
            list.add(VideoEvaluateForm2VideoEvaluate.
                    reConvert(videoEvaluate));
        }
        return ResultVOUtil.success(list);
    }
    //获取指定用户的所有视频评价
    @GetMapping("evaluate/get/user")
    public ResultVO<List<VideoEvaluateForm>> getAllByUsername(@RequestParam("username") String username){
        List<VideoEvaluateForm> list=new ArrayList<>();
        for (VideoEvaluate videoEvaluate : evaluateService.findAllEvaluateByUsername(username)) {
            list.add(VideoEvaluateForm2VideoEvaluate.
                    reConvert(videoEvaluate));
        }
        return ResultVOUtil.success(list);
    }

    /*
    * 视频匹配
    * */
    @GetMapping("match/label")
    public ResultVO<List<VideoForm>> matchByLabel(@RequestParam("videoLabel") String label){
        List<Video> list=new ArrayList<>();
        for (Video video : service.findAllVideo()) {
            if (video.getVideoLabel().contains(label)){
                list.add(video);
            }
        }
        if (list.isEmpty()){
            throw new RainException(ResultEnum.MATCH_FAILED);
        }
        return ResultVOUtil.success(list);
    }

    @GetMapping("match/teacher")
    public ResultVO<List<VideoForm>> matchByUsername(@RequestParam("username") String username){
        List<Video> list=service.findTeacherAllVideo(username);
        if (list.isEmpty()){
            throw new RainException(ResultEnum.MATCH_FAILED);
        }
        return ResultVOUtil.success(list);
    }

    private boolean isBuy(String videoId,String username){
        UV uv=uvService.getUV(videoId,username);
        float price=service.findVideo(videoId).getVideoPrice();
        if (price!=0&&uv==null) //必须先购买才能观看
            throw new RainException(ResultEnum.UPDATE_UV_FAILED);
        return true;
    }
}
