package myWorld.entity;

import java.util.List;

public class ResponseVO {
    private Integer status;
    private String message;
    private Object data;
    private List<?> rows;
    private Long total;

    public ResponseVO() {
        super();
    }

    public ResponseVO(Integer status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ResponseVO(Integer status, String message, Object data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseVO(Integer status, String message, List<?> rows, Long total) {
        super();
        this.status = status;
        this.message = message;
        this.rows = rows;
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
