package org.translate.min.message.request;

public class BaseMessage
{
	//������΢�ź�
	private String toUserName;
	//���ͷ��˺ţ�һ��openID)
	private String fromUserName;
	//��Ϣ����ʱ��
	private long creatTime;
	//��Ϣ���ͣ�text/image/location/link)
	private String messageType;
	//��Ϣ id��64λ����
	private long messageId;
	public String getToUserName()
	{
		return toUserName;
	}
	public void setToUserName(String toUserName)
	{
		this.toUserName = toUserName;
	}
	public String getFromUserName()
	{
		return fromUserName;
	}
	public void setFromUserName(String fromUserName)
	{
		this.fromUserName = fromUserName;
	}
	public long getCreatTime()
	{
		return creatTime;
	}
	public void setCreatTime(long creatTime)
	{
		this.creatTime = creatTime;
	}
	public String getMessageType()
	{
		return messageType;
	}
	public void setMessageType(String messageType)
	{
		this.messageType = messageType;
	}
	public long getMessageId()
	{
		return messageId;
	}
	public void setMessageId(long messageId)
	{
		this.messageId = messageId;
	}
	
}
