package org.translate.min.message.request;

public class VoiceMessage extends BaseMessage
{
	//ý��ID
	private String mediaId;
	//������ʽ
	private String format;
	public String getMediaId()
	{
		return mediaId;
	}
	public void setMediaId(String mediaId)
	{
		this.mediaId = mediaId;
	}
	public String getFormat()
	{
		return format;
	}
	public void setFormat(String format)
	{
		this.format = format;
	}	
}
