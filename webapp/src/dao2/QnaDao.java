package dao2;

import java.util.ArrayList;

import dto2.Qna;

public interface QnaDao {

	ArrayList<Qna> qnaList(String id, int page, int cnt)throws Exception;

	void qnaInsert(Qna qna)throws Exception;
	Qna qnaDetail(int qseq)throws Exception;

	void qnaDelete(int qseq)throws Exception;

	int getAllCount()throws Exception;

}
