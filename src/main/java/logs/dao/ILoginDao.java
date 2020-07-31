package logs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import logs.entity.User;

@Mapper
@Repository
public interface ILoginDao {

	User login(User user);

}
