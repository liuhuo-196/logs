package logs.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import logs.entity.CommonResult;
import logs.constant.ResultConstant;
import logs.service.ILogsService;

import springfox.documentation.annotations.ApiIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import logs.entity.LogsEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = "*")
@Api(tags = "logs接口")
@RequestMapping("/logs")
public class LogsController {


	private ILogsService service;

	@Autowired
	public LogsController(ILogsService service) {
		this.service = service;
	}
	
	/**
	 * 查询
	 *
	 * @return
	 */
	@ApiOperation(value = "查询")
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public CommonResult select(@RequestBody LogsEntity entity) {
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG, service.select(entity));
	}

	/**
	 * 模糊查询
	 *
	 * @return
	 */
	@ApiOperation(value = "模糊查询")
	@RequestMapping(value = "/likeSelect", method = RequestMethod.POST)
	public CommonResult likeSelect(@RequestBody LogsEntity entity) {
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG, service.likeSelect(entity));
	}

	/**
	 * 添加
	 *
	 * @return
	 */
	@ApiOperation(value = "添加")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult add(@RequestBody LogsEntity entity) {
		service.add(entity);
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
	}

	/**
	 * 删除
	 *
	 * @return
	 */
	@ApiOperation(value = "删除")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public CommonResult delete(@RequestBody LogsEntity entity) {
		LogsEntity logsEntity = service.delete(entity);
		if (logsEntity != null){
			service.delete(entity);
			return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
		}
		return new CommonResult(ResultConstant.FAIL_CODE, ResultConstant.FAIL_MSG);
	}
}
