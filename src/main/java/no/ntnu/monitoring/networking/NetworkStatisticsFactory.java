package no.ntnu.monitoring.networking;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class NetworkStatisticsFactory {
    public static List<NetworkInterface> getNetworkInterfaces() throws IOException {
        final List<NetworkInterface> interfaces = new LinkedList<>();
        final File file = new File("/proc/net/dev");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCounter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                lineCounter++;
                String[] lineSplit = line.trim().split("(\\s+|\\|)");
                if (lineCounter > 2) {
                    String interfaceName = lineSplit[0].replace(":", "");

                    NetworkInterface networkInterface = new NetworkInterface(interfaceName);
                    networkInterface.getReceive().setBytes(Long.valueOf(lineSplit[1]));
                    networkInterface.getReceive().setPackets(Long.valueOf(lineSplit[2]));
                    networkInterface.getReceive().setErrs(Long.valueOf(lineSplit[3]));
                    networkInterface.getReceive().setDrop(Long.valueOf(lineSplit[4]));
                    networkInterface.getReceive().setFifo(Long.valueOf(lineSplit[5]));
                    networkInterface.getReceive().setFrame(Long.valueOf(lineSplit[6]));
                    networkInterface.getReceive().setCompressed(Long.valueOf(lineSplit[7]));
                    networkInterface.getReceive().setMulticast(Long.valueOf(lineSplit[8]));

                    networkInterface.getTransmit().setBytes(Long.valueOf(lineSplit[9]));
                    networkInterface.getTransmit().setPackets(Long.valueOf(lineSplit[10]));
                    networkInterface.getTransmit().setErrs(Long.valueOf(lineSplit[11]));
                    networkInterface.getTransmit().setDrop(Long.valueOf(lineSplit[12]));
                    networkInterface.getTransmit().setFifo(Long.valueOf(lineSplit[13]));
                    networkInterface.getTransmit().setFrame(Long.valueOf(lineSplit[14]));
                    networkInterface.getTransmit().setCarrier(Long.valueOf(lineSplit[15]));
                    networkInterface.getTransmit().setCompressed(Long.valueOf(lineSplit[16]));

                    interfaces.add(networkInterface);
                }
            }
        }

        return interfaces;
    }
}
