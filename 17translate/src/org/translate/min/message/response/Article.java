package org.translate.min.message.response;

public class Article
{
	//ͼ����Ϣ����
	private String title;
	//ͼ����Ϣ����
	private String description;
	//ͼƬ���ӣ�֧��jpg,png��ʽ���Ϻõ�Ч��Ϊ��ͼ640*320��Сͼ80*80������ͼƬ���ӵ�������Ҫ�뿪������д�Ļ��������е�Urlһ��  
	private String pictureUrl;
	//���ͼ����Ϣ��ת����
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
	public String getPictureUrl()
	{
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl)
	{
		this.pictureUrl = pictureUrl;
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
