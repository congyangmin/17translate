package org.translate.min.message.response;

public class BaseMessage
{
	//���շ��˺ţ��յ���openID)
	private String toUserName;
	//������΢�ź�
	private String fromUserName;
	//��Ϣ����ʱ��
	private long creatTime;
	//��Ϣ����(text/music/news)
	private String messageType;
	//λ0x0001����־ʱ���Ǳ���յ�����Ϣ 
	private int funcFlag;
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
	public int getFuncFlag()
	{
		return funcFlag;
	}
	public void setFuncFlag(int funcFlag)
	{
		this.funcFlag = funcFlag;
	}
	
	
	
}
