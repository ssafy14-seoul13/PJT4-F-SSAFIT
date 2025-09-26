package com.pjt4.ssafit.dto.User;

public class Video {
	public static int no = 1;
    private int id;
    private String title;
    private String part; // 운동 부위
    private String url;
    private int viewCnt;

	public Video() {
	}
	
	public Video(String title, String part, String url) {
	    this.id = no++;
	    this.title = title;
	    this.part = part;
	    this.url = url;
	}
	
	// Getter와 Setter 메소드를 모두 추가해야 합니다.
	public int getId() {
	    return id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}
	

	
	public String getTitle() {
	    return title;
	}
	
	public void setTitle(String title) {
	    this.title = title;
	}
	
	public String getPart() {
	    return part;
	}
	
	public void setPart(String part) {
	    this.part = part;
	}
	
	public String getUrl() {
	    return url;
	}
	
	public void setUrl(String url) {
	    this.url = url;
	}
	
	public int getViewCnt() {
	    return viewCnt;
	}
	
	public void setViewCnt(int viewCnt) {
	    this.viewCnt = viewCnt;
	}
	
	@Override
	public String toString() {
	    return "Video{" +
	            "id=" + id +
	            ", title='" + title + '\'' +
	            ", part='" + part + '\'' +
	            ", url='" + url + '\'' +
	            ", viewCnt=" + viewCnt +
	            '}';
	}
}