package org.zongf.auto.generator.athm.vo;

import org.zongf.auto.generator.vo.ClassMetaVO;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class AthmValidateVO extends ClassMetaVO {

    // 不能为空
    private boolean isNotNull;

    // 最大长度
    private int maxLength;

    // 最小长度
    private int minLength;

}
