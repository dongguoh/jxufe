package com.gjx.jxufe.vo;

public class Link {

	private int id;

	// 链接的类别
	private int typeid;

	private String url;

	// 链接的名称
	private String name;

	private String image;

	public Link() {

	}

	private String getUrlFormat(String url)	{
		
		if(url.length()>=8&&url.substring(0,7).equalsIgnoreCase("http://")){
			return url;
		}
		return "http://"+url;
		
	}
	public Link(int typeid,String url,String name,String image) {

		this.typeid=typeid;
		this.url=getUrlFormat(url);
		this.name=name;
		this.image=image;
	}
	public Link(int id,int typeid,String name,String url,String image) {

		this.id=id;
		this.typeid=typeid;
		this.url=getUrlFormat(url);
		this.name=name;
		this.image=image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
