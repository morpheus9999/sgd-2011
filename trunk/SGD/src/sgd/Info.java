/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgd;

/**
 *
 * @author Jorge
 */
public class Info {
    String caller_id;
    int duration;
    int billsec;
    int billmsec;
    int progressec;
    int progress_mediasec;
    int flow_billsec;
    int mduration;
    int progressmsec;
    int progress_mediamsec;
    int flow_billmsec;
    int uduration;

    public Info(){}

    public Info(String caller_id, int duration, int billsec, int billmsec, int progressec, int progress_mediasec, int flow_billsec, int mduration, int progressmsec, int progress_mediamsec, int flow_billmsec, int uduration) {
        this.caller_id = caller_id;
        this.duration = duration;
        this.billsec = billsec;
        this.billmsec = billmsec;
        this.progressec = progressec;
        this.progress_mediasec = progress_mediasec;
        this.flow_billsec = flow_billsec;
        this.mduration = mduration;
        this.progressmsec = progressmsec;
        this.progress_mediamsec = progress_mediamsec;
        this.flow_billmsec = flow_billmsec;
        this.uduration = uduration;
    }



    public int getBillmsec() {
        return billmsec;
    }

    public void setBillmsec(int billmsec) {
        this.billmsec = billmsec;
    }

    public int getBillsec() {
        return billsec;
    }

    public void setBillsec(int billsec) {
        this.billsec = billsec;
    }

    public String getCaller_id() {
        return caller_id;
    }

    public void setCaller_id(String caller_id) {
        this.caller_id = caller_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFlow_billmsec() {
        return flow_billmsec;
    }

    public void setFlow_billmsec(int flow_billmsec) {
        this.flow_billmsec = flow_billmsec;
    }

    public int getFlow_billsec() {
        return flow_billsec;
    }

    public void setFlow_billsec(int flow_billsec) {
        this.flow_billsec = flow_billsec;
    }

    public int getMduration() {
        return mduration;
    }

    public void setMduration(int mduration) {
        this.mduration = mduration;
    }

    public int getProgress_mediamsec() {
        return progress_mediamsec;
    }

    public void setProgress_mediamsec(int progress_mediamsec) {
        this.progress_mediamsec = progress_mediamsec;
    }

    public int getProgress_mediasec() {
        return progress_mediasec;
    }

    public void setProgress_mediasec(int progress_mediasec) {
        this.progress_mediasec = progress_mediasec;
    }

    public int getProgressec() {
        return progressec;
    }

    public void setProgressec(int progressec) {
        this.progressec = progressec;
    }

    public int getProgressmsec() {
        return progressmsec;
    }

    public void setProgressmsec(int progressmsec) {
        this.progressmsec = progressmsec;
    }

    public int getUduration() {
        return uduration;
    }

    public void setUduration(int uduration) {
        this.uduration = uduration;
    }



    
}
