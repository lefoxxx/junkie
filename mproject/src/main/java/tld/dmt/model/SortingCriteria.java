package tld.dmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SortOrder;

import org.hibernate.annotations.SortType;

public class SortingCriteria {
	public static enum OrderType {
		ASCENDING,
		DESCENDING
	};
	
	public static class SortField {
		private String fieldName;
		private OrderType order;
		
		public SortField(String fieldName, OrderType order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public OrderType getOrder() {
			return order;
		}
		public void setOrder(OrderType order) {
			this.order = order;
		}
		
	}

	private List<SortField> fields = new ArrayList<SortField>();

	public void addSorting(String fieldName, OrderType order ) {
		fields.add(new SortField(fieldName, order));
	}
	
	public static SortingCriteria getCriteria(String fieldName, OrderType order) {
		SortingCriteria crit = new SortingCriteria();
		crit.addSorting(fieldName, order);
		return crit;
	}
	
	public List<SortField> getFields() {
		return fields;
	} 
	
}
