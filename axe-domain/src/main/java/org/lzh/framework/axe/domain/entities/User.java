package org.lzh.framework.axe.domain.entities;


import lombok.Data;

import java.io.Serializable;

/**
 * @description �û���Ϣ
 * @author Courser
 * @version 1
 * @date 2015/11/7 20:23
 */

@Data
public class User  implements Serializable{

    /**
     *id
     */
    private int id;
    /**
     * ����
     */
    private String age;
    /**
     * ����
     */
    private String userName;
    public User(){

    }

    public User(int id, String age, String userName) {
        super();
        this.id = id;
        this.age = age;
        this.userName = userName;
    }
}
