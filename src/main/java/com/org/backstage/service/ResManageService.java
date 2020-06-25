package com.org.backstage.service;



import com.org.backstage.pojo.PornhubCard;
import com.org.backstage.pojo.PornhubCartoon;
import com.org.backstage.pojo.PornhubCartoonInfo;
import com.org.backstage.pojo.PornhubVideo;

public interface ResManageService {
	public Integer insertRes(PornhubCartoonInfo pornhubCartoonInfo);
	public Integer insertCartoon(PornhubCartoon pornhubCartoon);
	public Integer insertCard(PornhubCard pornhubCard);
	public Integer insertVideo(PornhubVideo pornhubVideo);

}
