package no.ntnu.monitoring.networking;

public class NetworkInterface {
    private String name;
    private NetworkInterfaceMetrics transmit;
    private NetworkInterfaceMetrics receive;

    public NetworkInterface(String name) {
        this.name = name;
        this.transmit = new NetworkInterfaceMetrics();
        this.receive = new NetworkInterfaceMetrics();
    }

    public String getName() {
        return name;
    }

    public NetworkInterfaceMetrics getTransmit() {
        return transmit;
    }

    public NetworkInterfaceMetrics getReceive() {
        return receive;
    }
}
