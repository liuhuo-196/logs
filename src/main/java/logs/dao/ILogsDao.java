package logs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import logs.entity.LogsEntity;

@Mapper
@Repository
public interface ILogsDao extends IBaseDao<LogsEntity> {

}
