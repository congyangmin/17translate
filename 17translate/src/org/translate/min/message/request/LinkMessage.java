package org.translate.min.message.request;

public class LinkMessage extends BaseMessage
{
	//������Ϣ
	private String title;
	//������Ϣ
	private String description;
	//��Ϣ����
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
