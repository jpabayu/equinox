package org.equinox.api.qris;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.MuleContext;
import org.mule.api.context.notification.MuleContextNotificationListener;
import org.mule.api.context.notification.ServerNotification;
import org.mule.context.notification.MuleContextNotification;

import com.hazelcast.core.HazelcastInstance;

@SuppressWarnings("rawtypes")
public class GlobalComponent implements MuleContextNotificationListener {
	protected final Log logger = LogFactory.getLog(this.getClass());

	private static HazelcastInstance hazelcastInstance;

	public static HazelcastInstance getHazelcastInstance() {
		return hazelcastInstance;
	}

	@Override
	public void onNotification(ServerNotification notification) {
		// if the context has been started
		if (notification.getAction() == MuleContextNotification.CONTEXT_STARTED) {
			logger.info("#GLOBAL COMPONENT NOTIFICATION: APP STARTED");
			// obtain the context
			MuleContext muleContext = ((MuleContextNotification) notification).getMuleContext();

			try {
				hazelcastInstance = muleContext.getRegistry().lookupObject(HazelcastInstance.class);
			} catch (Exception e) {
				logger.error("#GLOBAL COMPONENT INIT HAZELCAST : " + e.getMessage());
			}

			/*
            //get a hold of the Flows defined in the application
            Collection<FlowConstruct> flows = muleContext.getRegistry().lookupFlowConstructs();
            for(FlowConstruct flowConstruct : flows) {
                Flow flow = (Flow)flowConstruct;
                //if the initial state was stopped
                if (StringUtils.equals(flow.getInitialState(), AbstractFlowConstruct.INITIAL_STATE_STOPPED)){
                    //start the flow
                    try {
                        logger.info("## STARTING FLOW " + flow.getName());
                        flow.start();
                    } catch (MuleException e) {
                        //TODO: handle the exception
                        e.printStackTrace();
                    }
                }
            }
            */
		}
	}
}
