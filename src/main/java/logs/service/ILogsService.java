package logs.service;

import javax.servlet.http.HttpServletResponse;

import logs.entity.LogsEntity;
import logs.entity.PageData;
import java.util.List;

public interface ILogsService {

	void add(LogsEntity entity);
	
	LogsEntity delete(LogsEntity entity);
	
	List<LogsEntity> select(LogsEntity entity);
	
	PageData<LogsEntity> likeSelect(LogsEntity entity);

}
