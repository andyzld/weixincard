package com.zld.pay.model;

public class opHistory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column op_history.userid
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    private String userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column op_history.name
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column op_history.date
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    private String date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column op_history.opType
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    private String optype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column op_history.cardId
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    private String cardid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column op_history.optext
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    private String optext;

    @Override
    public String toString() {
        return "opHistory{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", optype='" + optype + '\'' +
                ", cardid='" + cardid + '\'' +
                ", optext='" + optext + '\'' +
                '}';
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column op_history.userid
     *
     * @return the value of op_history.userid
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column op_history.userid
     *
     * @param userid the value for op_history.userid
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column op_history.name
     *
     * @return the value of op_history.name
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column op_history.name
     *
     * @param name the value for op_history.name
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column op_history.date
     *
     * @return the value of op_history.date
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column op_history.date
     *
     * @param date the value for op_history.date
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column op_history.opType
     *
     * @return the value of op_history.opType
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public String getOptype() {
        return optype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column op_history.opType
     *
     * @param optype the value for op_history.opType
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public void setOptype(String optype) {
        this.optype = optype == null ? null : optype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column op_history.cardId
     *
     * @return the value of op_history.cardId
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public String getCardid() {
        return cardid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column op_history.cardId
     *
     * @param cardid the value for op_history.cardId
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column op_history.optext
     *
     * @return the value of op_history.optext
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public String getOptext() {
        return optext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column op_history.optext
     *
     * @param optext the value for op_history.optext
     *
     * @mbg.generated Tue Jan 02 17:29:01 CST 2018
     */
    public void setOptext(String optext) {
        this.optext = optext == null ? null : optext.trim();
    }
}