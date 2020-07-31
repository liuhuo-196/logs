package logs.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logs.dao.ILogsDao;
import logs.service.ILogsService;
import logs.entity.PageData;
//import logs.utils.ExcelUtil;
import logs.utils.PageUtil;
import java.util.LinkedHashMap;
import logs.entity.LogsEntity;
import java.util.List;
import java.util.Map;

@Service
public class LogsService implements ILogsService {

	
	private ILogsDao dao;

	@Autowired
	public LogsService(ILogsDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void add(LogsEntity entity) {
		dao.add(entity);
	}
	
	@Override
	public LogsEntity delete(LogsEntity entity) {
		dao.delete(entity);
        return entity;
    }
	
	@Override
	public List<LogsEntity> select(LogsEntity entity) {
		return dao.select(entity);
	}
	
	@Override
	public PageData<LogsEntity> likeSelect(LogsEntity entity) {
	
		return PageUtil.getPageData(entity, dao);
	}

}
