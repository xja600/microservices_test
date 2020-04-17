package com.example.eureka_client.domain;

import lombok.*;

/**
 * @ClassName ExceptionEntity
 * @Description TODD
 * @Author MG01857
 * @Date 2019/4/29
 * @Version 1.0
 **/

/*@Setter
@Getter*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionEntity {

    private String description;

    private String className;

    private String methodName;

    private String params;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
