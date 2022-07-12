
/*
 * [nw] Syed Kazmi
 *
 * Copyright (c) 2022.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of The New Waves
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with The New Wave.
 *
 */
package com.samkaz.heroku.mechanic.dto;

                    

public class  CustomerDto {

    private int custid;
    private String custfirst;
    private String custlast;
    private String custdesc;
    private String custaddress;

    public CustomerDto() {
    }

    /*
     * Getter of Custid
     */
    public int getCustid() {
        return custid;
    }

    /*
     * Setter of Custid
     */
    public void setCustid(int custid) {
        this.custid = custid;
    }
    /*
     * Getter of Custfirst
     */
    public String getCustfirst() {
        return custfirst;
    }

    /*
     * Setter of Custfirst
     */
    public void setCustfirst(String custfirst) {
        this.custfirst = custfirst;
    }
    /*
     * Getter of Custlast
     */
    public String getCustlast() {
        return custlast;
    }

    /*
     * Setter of Custlast
     */
    public void setCustlast(String custlast) {
        this.custlast = custlast;
    }
    /*
     * Getter of Custdesc
     */
    public String getCustdesc() {
        return custdesc;
    }

    /*
     * Setter of Custdesc
     */
    public void setCustdesc(String custdesc) {
        this.custdesc = custdesc;
    }
    /*
     * Getter of Custaddress
     */
    public String getCustaddress() {
        return custaddress;
    }

    /*
     * Setter of Custaddress
     */
    public void setCustaddress(String custaddress) {
        this.custaddress = custaddress;
    }


}
