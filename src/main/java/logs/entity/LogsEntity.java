package logs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import  java.sql.Timestamp;

@ApiModel
public class LogsEntity extends CommonEntity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
	 *  logId
	 */
	@ApiModelProperty(value = "logId", name = "logId")
    private Integer logId;
    /**
	 *  logs
	 */
	@ApiModelProperty(value = "logs", name = "logs")
    private String logs;
    /**
	 *  createTime
	 */
	@ApiModelProperty(value = "createTime", name = "createTime")
    private Timestamp createTime;


    /**
	 *  get logId
	 */
    public Integer getLogId() {
		return logId;
	}

    /**
	 *  set logId
	 */
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
    /**
	 *  get logs
	 */
    public String getLogs() {
		return logs;
	}

    /**
	 *  set logs
	 */
	public void setLogs(String logs) {
		this.logs = logs;
	}
    /**
	 *  get createTime
	 */
    public Timestamp getCreateTime() {
		return createTime;
	}

    /**
	 *  set createTime
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


}
