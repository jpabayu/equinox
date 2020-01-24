package org.equinox.api.process;

import org.mule.api.MuleContext;
import org.mule.api.context.MuleContextAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Configurator implements ApplicationContextAware, MuleContextAware {

	private transient ApplicationContext context;
	private transient MuleContext muleContext;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.setContext(context);

	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public void setMuleContext(MuleContext context) {
		this.muleContext = context;
	}

	public MuleContext getMuleContext() {
		return this.muleContext;
	}

}
