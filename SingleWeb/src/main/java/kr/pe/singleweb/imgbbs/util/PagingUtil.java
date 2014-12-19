package kr.pe.singleweb.imgbbs.util;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * PagingUtil
 * 		: 페이징 처리 클래스.
 * 
 * @author 강인웅 e-mail: woong8609@gmail.com
 * @since 2014. 12. 19.
 */
public class PagingUtil
{
	/**
	 * pageSize
	 * 		: 페이지당 게시 글 수.
	 */
	private int pageSize;
	/**
	 * pageBlockSize
	 * 		: 블럭당 페이지 수.
	 */
	private int pageBlockSize;
	/**
	 * firstRow
	 * 		: 현재 페이지의 처음 글 번호.
	 */
	private int firstRow;
	/**
	 * lastRow
	 * 		: 현재 페이지의 마지막 글 번호.
	 */
	private int lastRow;
	/**
	 * curPage
	 * 		: 현재 페이지 번호.
	 */
	private int curPage;
	/**
	 * firstPage
	 * 		: 현재 페이지 블럭의 처음 페이지 번호.
	 */
	private int firstPage;
	/**
	 * lastPage
	 * 		: 현재 페이지 블럭의 마지막 페이지 번호.
	 */
	private int lastPage;
	/**
	 * curBlock
	 * 		: 현재 페이지 블럭 번호.
	 */
	private int curBlock;
	/**
	 * prevBlock
	 * 		: 현재의 이전 페이지 블럭 처음 페이지 번호.
	 */
	private int prevBlock;
	/**
	 * nextBlock
	 * 		: 현재의 다음 페이지 블럭 처음 페이지 번호.
	 */
	private int nextBlock;
	/**
	 * totalCnt
	 * 		: 게시 글 전체 수.
	 */
	private int totalCnt;
	/**
	 * viewRowCnt
	 * 		: 현재 페이지에 보여줄 게시 글  수.
	 */
	private int viewRowCnt;
	/**
	 * viewPageCnt
	 * 		: 현재 블럭에 보여줄 페이지  수.
	 */
	private int viewPageCnt;
	/**
	 * pageBlockCnt
	 * 		: 페이지 블럭 전체 수.
	 */
	private int pageBlockCnt;
	
	public int getPageSize()
	{
		return pageSize;
	}
	public int getPageBlockSize()
	{
		return pageBlockSize;
	}
	public int getFirstRow()
	{
		return firstRow;
	}
	public int getLastRow()
	{
		return lastRow;
	}
	public int getCurPage()
	{
		return curPage;
	}
	public int getFirstPage()
	{
		return firstPage;
	}
	public int getLastPage()
	{
		return lastPage;
	}
	public int getCurBlock()
	{
		return curBlock;
	}
	public int getPrevBlock()
	{
		return prevBlock;
	}
	public int getNextBlock()
	{
		return nextBlock;
	}
	public int getTotalCnt()
	{
		return totalCnt;
	}
	public int getViewRowCnt()
	{
		return viewRowCnt;
	}
	public int getViewPageCnt()
	{
		return viewPageCnt;
	}
	public int getPageBlockCnt()
	{
		return pageBlockCnt;
	}

	/**
	 * Paging 생성.
	 * 
	 * @param pNo
	 * 		: 현재 페이지 번호.
	 * @param tCnt
	 * 		: 게시 글 전체 수.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 19.
	 */
	public void makePaging(int pNo, int tCnt)
	{
		this.curPage = pNo;
		this.totalCnt = tCnt;
		makePaging();
	}
	
	/**
	 * Paging 생성.
	 * 
	 * @param pNo
	 * 		: 현재 페이지 번호.
	 * @param tCnt
	 * 		: 게시 글 전체 수.
	 * @param pSize
	 * 		: 페이지당 게시 글 수.
	 * @param pbSize
	 * 		: 블럭당 페이지 수.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 19.
	 */
	public void makePaging(int pNo, int tCnt, int pSize, int pbSize)
	{
		this.curPage = pNo;
		this.totalCnt = tCnt;
		this.pageSize = pSize;
		this.pageBlockSize = pbSize;
		makePaging();
	}
	
	/**
	 * Paging 처리 값 설정. (row, page, pageBlock)
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 19.
	 */
	private void makePaging()
	{
		if (this.totalCnt == 0)
		{
			return;
		}
		if (this.pageSize == 0)
		{
			this.pageSize = 10;
		}
		if (this.pageBlockSize == 0)
		{
			this.pageBlockSize = 10;
		}
		if (this.curPage == 0)
		{
			this.curPage = 1;
		}
		if (this.curBlock == 0)
		{
			this.curBlock = 1;
		}
		
		/** Row setting. */
		this.viewRowCnt = totalCnt - (curPage - 1) * pageSize;

		this.firstRow = (curPage - 1) * pageSize + 1;
		this.lastRow = curPage * pageSize;
		
		if (lastRow > totalCnt)
		{
			this.lastRow = totalCnt;
		}

		/** Page Block setting. */
		this.pageBlockCnt = totalCnt / (pageSize * pageBlockSize)
						+ (totalCnt % (pageSize * pageBlockSize) == 0 ? 0 : 1);
		
		this.curBlock = (int) Math.ceil((double) curPage / pageBlockSize);
		
		this.prevBlock = (curBlock - 2) * pageBlockSize + 1;
		this.nextBlock = curBlock * pageBlockSize + 1;

		/** Page setting. */
		this.viewPageCnt = totalCnt / pageSize + (totalCnt % pageSize == 0 ? 0 : 1);
		
		this.firstPage = pageBlockSize * (curBlock - 1) + 1;
		this.lastPage = firstPage + pageBlockSize - 1;
		
		if (lastPage > viewPageCnt)
		{
			this.lastPage = viewPageCnt;
		}
	}
	
	/** 
	 * Override 이유
	 * 		: 'toString()' Method를 해당 클래스에 맞게 overriding.
	 *
	 * @author 강인웅 e-mail: woong8609@gmail.com
	 * @since 2014. 12. 19.
	 */
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
