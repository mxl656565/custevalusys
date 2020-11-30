package com.waymap.custevalusys.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Evaluation implements Serializable {
    @ApiModelProperty(value = "评价id")
    private Integer id;

    @ApiModelProperty(value = "问题(1~4)")
    private Integer question;

    @ApiModelProperty(value = "分值(1~5)")
    private Integer points;

    @ApiModelProperty(value = "评估时间")
    private Date evaluatime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getEvaluatime() {
        return evaluatime;
    }

    public void setEvaluatime(Date evaluatime) {
        this.evaluatime = evaluatime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", question=").append(question);
        sb.append(", points=").append(points);
        sb.append(", evaluatime=").append(evaluatime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}