package br.com.soujava;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		Store store = storeByContext(context);
		store.put("start", System.currentTimeMillis());
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		Store store = storeByContext(context);
		
		long startTime = store.get("start", Long.class);
		long duration = System.currentTimeMillis() - startTime;
		
		System.out.println(String.format("Method [%s] took %s ms", context.getRequiredTestMethod().getName(), duration));
	}

	private Store storeByContext(ExtensionContext context) {
		return context.getStore(Namespace.create(getClass(), context.getRequiredTestMethod()));
	}

}
