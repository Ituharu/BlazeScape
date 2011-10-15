package com.iClarity.io;

import com.iClarity.*;
import com.iClarity.misc.*;

public class IOThread implements Runnable {

	@Override
	public void run() {
		int cycleTime = 30;
		long lastTicks = 0;
		long totalTimeSpentProcessing = 0;
		int waitFails = 0;
		int cycle = 0;

		while (!GameEngine.shutdownServer) {
			GameEngine.playerHandler.processIOClients();
			long timeSpent = System.currentTimeMillis() - lastTicks;
			totalTimeSpentProcessing += timeSpent;

			if (timeSpent >= cycleTime) {
				timeSpent = cycleTime;

				if (++waitFails > 100) {
					GameEngine.shutdownServer = true;
					Misc.println("[KERNEL]: machine is too slow to run this server!");
				}
			}

			try {
				Thread.sleep(cycleTime-timeSpent);
			} catch(java.lang.Exception _ex) {

			}
			lastTicks = System.currentTimeMillis();
			cycle++;

			if (cycle % 100 == 0) {
				@SuppressWarnings("unused")
				float time = ((float)totalTimeSpentProcessing) / cycle;
			}
		}
	}

}