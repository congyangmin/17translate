package org.translate.min.message.request;

public class LinkMessage extends BaseMessage
{
	//标题消息
	private String title;
	//描述消息
	private String description;
	//消息链接
	private String url;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	

	
}
