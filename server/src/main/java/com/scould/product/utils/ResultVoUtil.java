package com.scould.product.utils;

import com.scould.product.vo.ResultVo;

public class ResultVoUtil {
    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }
}
