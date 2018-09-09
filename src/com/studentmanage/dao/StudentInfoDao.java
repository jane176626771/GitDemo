package com.studentmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanage.bean.StudentInfo;

public class StudentInfoDao extends BaseDao {
	Connection conn = null;
	public StudentInfoDao(){
	  conn = getConnection(); 
	}
	/* 
	 * flag:1代表学校统计；2 代表就业地点；3专业就业率；4代表院系就业率
	 */
	public List<Integer> state(StudentInfo stu,String flag){
		List<Integer> list = new ArrayList<Integer>();
		int total = 0;
		int stateresult = 0;
		List<String> value = new ArrayList<String>();
		 if(conn!=null){
			 String sql = "select * from studentinfo where 1=1";
			 if(!"".equals(stu.getBysj())&&stu.getBysj()!=null){
				 sql += " and bysj=?";
				 value.add(stu.getBysj());
			 }
			 if(!"".equals(stu.getJyd())&&stu.getJyd()!=null){
				 sql += " and jyd=?";
				 value.add(stu.getJyd());
			 }
			 if(!"".equals(stu.getYx())&&stu.getYx()!=null){
				 sql += " and yx=?";
				 value.add(stu.getYx());
			 }
			 if(!"".equals(stu.getZy())&&stu.getZy()!=null){
				 sql += " and zy=?";
				 value.add(stu.getZy());
			 }
			   try {
				
			    PreparedStatement pstm = conn.prepareStatement(sql);
			    for(int i=1;i<=value.size();i++){
			    	pstm.setString(i,value.get(i-1));
			    }
			    ResultSet rs = pstm.executeQuery();
			    while(rs.next()){
			    	++total;
			    	if("1".equals(flag)){
				    	if("是".equals(rs.getString("sfjy"))){
				    		++stateresult;
				    	}
			    	}
			    }
			} catch (SQLException e) {
				System.out.println("==============="+e.getMessage());
			    e.printStackTrace();
			}
		 }
		 list.add(stateresult);
		 list.add(total);
		return list;
	}
	
	public List<StudentInfo> queryByCondi(StudentInfo stu){
		List<StudentInfo> resultList = new ArrayList<StudentInfo>();
		List<String> value = new ArrayList<String>();
		 if(conn!=null){
			 String sql = "select * from studentinfo where 1=1";
			 if(!"".equals(stu.getXuehao())&&stu.getXuehao()!=null){
				 sql += " and xuehao=?";
				 value.add(stu.getXuehao());
			 }
			 if(!"".equals(stu.getBysj())&&stu.getBysj()!=null){
				 sql += " and bysj=?";
				 value.add(stu.getBysj());
			 }
			 if(!"".equals(stu.getSyd())&&stu.getSyd()!=null){
				 sql += " and syd=?";
				 value.add(stu.getSyd());
			 }
			 if(!"".equals(stu.getJyd())&&stu.getJyd()!=null){
				 sql += " and jyd=?";
				 value.add(stu.getJyd());
			 }
			 if(!"".equals(stu.getYx())&&stu.getYx()!=null){
				 sql += " and yx=?";
				 value.add(stu.getYx());
			 }
			 if(!"".equals(stu.getZy())&&stu.getZy()!=null){
				 sql += " and zy=?";
				 value.add(stu.getZy());
			 }
			   try {
				
			    PreparedStatement pstm = conn.prepareStatement(sql);
			    for(int i=1;i<=value.size();i++){
			    	pstm.setString(i,value.get(i-1));
			    }
			    ResultSet rs = pstm.executeQuery();
			    
			    while(rs.next()){
			    	StudentInfo u = new StudentInfo();
			    	u.setId(rs.getInt("id"));
			    	u.setXuehao(rs.getString("xuehao"));
			    	u.setSyd(rs.getString("syd"));
			    	u.setJyd(rs.getString("jyd"));
			    	u.setBj(rs.getString("bj"));
			    	u.setXm(rs.getString("xm"));
			    	u.setXb(rs.getString("xb"));
			    	u.setMz(rs.getString("mz"));
			    	u.setSr(rs.getString("sr"));
			    	u.setZzmm(rs.getString("zzmm"));
			    	u.setIdcard(rs.getString("idcard"));
			    	u.setLxdh(rs.getString("lxdh"));
			    	u.setDzyx(rs.getString("dzyx"));
			    	u.setSfjy(rs.getString("sfjy"));
			    	u.setYx(rs.getString("yx"));
			    	u.setZy(rs.getString("zy"));
			    	u.setBjzw(rs.getString("bjzw"));
			    	u.setXshzw(rs.getString("xshzw"));
			    	u.setBysj(rs.getString("bysj"));
			    	u.setBjmc(rs.getString("bjmc"));
			    	u.setBzr(rs.getString("bzr"));
			    	u.setBzrlxdh(rs.getString("bzrlxdh"));
			    	u.setXz(rs.getString("xz"));
			    	u.setSfsf(rs.getString("sfsf"));
			    	resultList.add(u);
			    }
			} catch (SQLException e) {
				System.out.println("==============="+e.getMessage());
			    e.printStackTrace();
			}
		 }
		 return resultList;
	}
	public List<StudentInfo> queryAll(){
		 List<StudentInfo> resultList = new ArrayList<StudentInfo>();
		 if(conn!=null){
			   try {
			    PreparedStatement pstm = conn.prepareStatement("select * from studentinfo ");
			    ResultSet rs = pstm.executeQuery();
			    while(rs.next()){
			    	StudentInfo u = new StudentInfo();
			    	u.setId(rs.getInt("id"));
			    	u.setXuehao(rs.getString("xuehao"));
			    	u.setSyd(rs.getString("syd"));
			    	u.setJyd(rs.getString("jyd"));
			    	u.setBj(rs.getString("bj"));
			    	u.setXm(rs.getString("xm"));
			    	u.setXb(rs.getString("xb"));
			    	u.setMz(rs.getString("mz"));
			    	u.setSr(rs.getString("sr"));
			    	u.setZzmm(rs.getString("zzmm"));
			    	u.setIdcard(rs.getString("idcard"));
			    	u.setLxdh(rs.getString("lxdh"));
			    	u.setDzyx(rs.getString("dzyx"));
			    	u.setSfjy(rs.getString("sfjy"));
			    	u.setYx(rs.getString("yx"));
			    	u.setZy(rs.getString("zy"));
			    	u.setBjzw(rs.getString("bjzw"));
			    	u.setXshzw(rs.getString("xshzw"));
			    	u.setBysj(rs.getString("bysj"));
			    	u.setBjmc(rs.getString("bjmc"));
			    	u.setBzr(rs.getString("bzr"));
			    	u.setBzrlxdh(rs.getString("bzrlxdh"));
			    	u.setXz(rs.getString("xz"));
			    	u.setSfsf(rs.getString("sfsf"));
			    	resultList.add(u);
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		 }
		 return resultList;
	 }
	
	 public boolean addStudent(StudentInfo stu){
			int result = 0;
			if(conn!=null){
				try {
					PreparedStatement pstm = conn.prepareStatement("insert into studentinfo("
							+ "xuehao,syd,jyd,bj,xm,xb,mz,sr,zzmm,idcard,lxdh,dzyx," +
							"sfjy,yx,zy,bjzw,xshzw,bysj,bjmc,bzr,bzrlxdh,xz,sfsf)"
							+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstm.setString(1, stu.getXuehao());
					pstm.setString(2, stu.getSyd());
					pstm.setString(3, stu.getJyd());
					pstm.setString(4, stu.getBj());
					pstm.setString(5, stu.getXm());
					pstm.setString(6, stu.getXb());
					pstm.setString(7, stu.getMz());
					pstm.setString(8, stu.getSr());
					pstm.setString(9, stu.getZzmm());
					pstm.setString(10, stu.getIdcard());
					pstm.setString(11, stu.getLxdh());
					pstm.setString(12, stu.getDzyx());
					pstm.setString(13, stu.getSfjy());
					pstm.setString(14, stu.getYx());
					pstm.setString(15, stu.getZy());
					pstm.setString(16, stu.getBjzw());
					pstm.setString(17, stu.getXshzw());
					pstm.setString(18, stu.getBysj());
					pstm.setString(19, stu.getBjmc());
					pstm.setString(20, stu.getBzr());
					pstm.setString(21, stu.getBzrlxdh());
					pstm.setString(22, stu.getXz());
					pstm.setString(23, stu.getSfsf());
					result = pstm.executeUpdate();
				} catch (SQLException e) {
					System.out.print("数据异常!");
				}
			}
			if(result>0){
				return true;
			}else{
				System.out.println("添加数据失败！");
				return false;
			}
		}
	 public StudentInfo queryById(int id){
		 StudentInfo stu = null;
		 if(conn!=null){
				try {
					PreparedStatement pstm = conn.prepareStatement("select * from studentinfo where id=?");
					pstm.setInt(1, id);
					ResultSet rs = pstm.executeQuery();
					if(rs!=null){
						while(rs.next()){
							stu = new StudentInfo();
							stu.setId(rs.getInt("id"));
					    	stu.setXuehao(rs.getString("xuehao"));
					    	stu.setSyd(rs.getString("syd"));
					    	stu.setJyd(rs.getString("jyd"));
					    	stu.setBj(rs.getString("bj"));
					    	stu.setXm(rs.getString("xm"));
					    	stu.setXb(rs.getString("xb"));
					    	stu.setMz(rs.getString("mz"));
					    	stu.setSr(rs.getString("sr"));
					    	stu.setZzmm(rs.getString("zzmm"));
					    	stu.setIdcard(rs.getString("idcard"));
					    	stu.setLxdh(rs.getString("lxdh"));
					    	stu.setDzyx(rs.getString("dzyx"));
					    	stu.setSfjy(rs.getString("sfjy"));
					    	stu.setYx(rs.getString("yx"));
					    	stu.setZy(rs.getString("zy"));
					    	stu.setBjzw(rs.getString("bjzw"));
					    	stu.setXshzw(rs.getString("xshzw"));
					    	stu.setBysj(rs.getString("bysj"));
					    	stu.setBjmc(rs.getString("bjmc"));
					    	stu.setBzr(rs.getString("bzr"));
					    	stu.setBzrlxdh(rs.getString("bzrlxdh"));
					    	stu.setXz(rs.getString("xz"));
					    	stu.setSfsf(rs.getString("sfsf"));
						}
					}
				} catch (SQLException e) {
					System.out.print("判断记录是否存在失败!");
				}
			}
			return stu;
		}
		 public boolean updateStudent(StudentInfo stu){
				int result = 0;
				if(conn!=null){
					try {
						PreparedStatement pstm = conn.prepareStatement("update studentinfo set " +
							"xuehao=?,syd=?,jyd=?,bj=?,xm=?,xb=?,mz=?,sr=?,zzmm=?,idcard=?,lxdh=?,dzyx=?," +
							"sfjy=?,yx=?,zy=?,bjzw=?,xshzw=?,bysj=?,bjmc=?,bzr=?,bzrlxdh=?,xz=?,sfsf=?"
								+ " where id=?");
						pstm.setString(1, stu.getXuehao());
						pstm.setString(2, stu.getSyd());
						pstm.setString(3, stu.getJyd());
						pstm.setString(4, stu.getBj());
						pstm.setString(5, stu.getXm());
						pstm.setString(6, stu.getXb());
						pstm.setString(7, stu.getMz());
						pstm.setString(8, stu.getSr());
						pstm.setString(9, stu.getZzmm());
						pstm.setString(10, stu.getIdcard());
						pstm.setString(11, stu.getLxdh());
						pstm.setString(12, stu.getDzyx());
						pstm.setString(13, stu.getSfjy());
						pstm.setString(14, stu.getYx());
						pstm.setString(15, stu.getZy());
						pstm.setString(16, stu.getBjzw());
						pstm.setString(17, stu.getXshzw());
						pstm.setString(18, stu.getBysj());
						pstm.setString(19, stu.getBjmc());
						pstm.setString(20, stu.getBzr());
						pstm.setString(21, stu.getBzrlxdh());
						pstm.setString(22, stu.getXz());
						pstm.setString(23, stu.getSfsf());
						pstm.setInt(24, stu.getId());
						result = pstm.executeUpdate();
					} catch (SQLException e) {
						System.out.print("数据异常!"+e.getMessage());
					}
				}
				if(result>0){
					return true;
				}else{
					System.out.println("修改数据失败！");
					return false;
				}
			}
}
