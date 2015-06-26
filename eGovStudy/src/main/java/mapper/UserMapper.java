package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import user.vo.UserVO;

public interface UserMapper {
	
 	 
 	 @Select("select * from userinfo")  
     List<UserVO> list();
 	 
 	
     @Delete("delete from userinfo where  userid  = #{userid}") 
     int delete(String uid);

	 @Update("insert into userinfo "+
	  	     "(userid, username, userpwd, email, phone, address) "+ 
	  	     "values (#{userid}, #{username}, #{userpwd}, "
	  	              + " #{email}, #{phone},#{address})") 	
	 int add(UserVO vo); 	
}













