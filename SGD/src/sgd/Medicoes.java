/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgd;

/**
 *
 * @author David
 */
public class Medicoes {

    long sum = 0;
    long n = 0;
    long ssum = 0;
    long max;
    long min;

    public Medicoes() {
    }

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public void add(long latency) {
        n++;
        sum += latency;
        ssum += (latency * latency);
        max = Math.max(max, latency);
        min = Math.min(min, latency);
    }

    public long getAvg() {
        return sum / n;
    }

    public double getStdev() {
        return Math.sqrt(ssum / n - getAvg() * getAvg());
    }
}
