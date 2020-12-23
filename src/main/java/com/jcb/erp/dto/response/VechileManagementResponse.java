package com.jcb.erp.dto.response;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class VechileManagementResponse {
	
	private Boolean success;
    private String verdict;
    private String message;
    private String time;
//    private Data data;

    @Override
    public String toString() {
        return ":{\"verdict\"=\"" + verdict + "\", \"message\"=\"" + message
                + "\", \"time\"=\"" + time + "\", \"data\"=\"" + 1 + "\"}";
    }
}