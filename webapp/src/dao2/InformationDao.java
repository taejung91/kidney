package dao2;

import java.util.ArrayList;

import dto2.Hospital;
import dto2.Information;

public interface InformationDao {

	ArrayList<Information> list(int kind, int page, int cnt)throws Exception;

	Information detail(int iseq, int kind)throws Exception;

	ArrayList<Hospital> listHospital(String search, int page, int cnt)throws Exception;

	Hospital detailHospital(String no)throws Exception;

	int getAllCount(String search)throws Exception;

	int getAllCount(int kind)throws Exception;


}
