package org.translate.min.message.response;

import java.util.List;

public class NewsMessage extends BaseMessage
{
		//ͼ����Ϣ����������Ϊ10������
		public int articleCount;
		//����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��ItemΪ��ͼ
		private List<Article> articles;
		public int getArticleCount()
		{
			return articleCount;
		}
		public void setArticleCount(int articleCount)
		{
			this.articleCount = articleCount;
		}
		public List<Article> getArticles()
		{
			return articles;
		}
		public void setArticles(List<Article> articles)
		{
			this.articles = articles;
		}
		
		
	
}
