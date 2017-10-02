package no.ntnu.monitoring.networking;

public class NetworkInterfaceMetrics {
    private long bytes;
    private long packets;
    private long errs;
    private long drop;
    private long fifo;
    private long frame;
    private long compressed;
    private long multicast;
    private long carrier;

    public long getBytes() {
        return bytes;
    }

    public void setBytes(long bytes) {
        this.bytes = bytes;
    }

    public long getPackets() {
        return packets;
    }

    public void setPackets(long packets) {
        this.packets = packets;
    }

    public long getErrs() {
        return errs;
    }

    public void setErrs(long errs) {
        this.errs = errs;
    }

    public long getDrop() {
        return drop;
    }

    public void setDrop(long drop) {
        this.drop = drop;
    }

    public long getFifo() {
        return fifo;
    }

    public void setFifo(long fifo) {
        this.fifo = fifo;
    }

    public long getFrame() {
        return frame;
    }

    public void setFrame(long frame) {
        this.frame = frame;
    }

    public long getCompressed() {
        return compressed;
    }

    public void setCompressed(long compressed) {
        this.compressed = compressed;
    }

    public long getMulticast() {
        return multicast;
    }

    public void setMulticast(long multicast) {
        this.multicast = multicast;
    }

    public long getCarrier() {
        return carrier;
    }

    public void setCarrier(long carrier) {
        this.carrier = carrier;
    }
}
