package com.compoent.entity;

import java.util.ArrayList;
import java.util.List;

public class ComponentTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComponentTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdIsNull() {
            addCriterion("type_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdIsNotNull() {
            addCriterion("type_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdEqualTo(String value) {
            addCriterion("type_parent_id =", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdNotEqualTo(String value) {
            addCriterion("type_parent_id <>", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdGreaterThan(String value) {
            addCriterion("type_parent_id >", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_parent_id >=", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdLessThan(String value) {
            addCriterion("type_parent_id <", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdLessThanOrEqualTo(String value) {
            addCriterion("type_parent_id <=", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdLike(String value) {
            addCriterion("type_parent_id like", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdNotLike(String value) {
            addCriterion("type_parent_id not like", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdIn(List<String> values) {
            addCriterion("type_parent_id in", values, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdNotIn(List<String> values) {
            addCriterion("type_parent_id not in", values, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdBetween(String value1, String value2) {
            addCriterion("type_parent_id between", value1, value2, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdNotBetween(String value1, String value2) {
            addCriterion("type_parent_id not between", value1, value2, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andExtr1IsNull() {
            addCriterion("extr1 is null");
            return (Criteria) this;
        }

        public Criteria andExtr1IsNotNull() {
            addCriterion("extr1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtr1EqualTo(String value) {
            addCriterion("extr1 =", value, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1NotEqualTo(String value) {
            addCriterion("extr1 <>", value, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1GreaterThan(String value) {
            addCriterion("extr1 >", value, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1GreaterThanOrEqualTo(String value) {
            addCriterion("extr1 >=", value, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1LessThan(String value) {
            addCriterion("extr1 <", value, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1LessThanOrEqualTo(String value) {
            addCriterion("extr1 <=", value, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1Like(String value) {
            addCriterion("extr1 like", value, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1NotLike(String value) {
            addCriterion("extr1 not like", value, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1In(List<String> values) {
            addCriterion("extr1 in", values, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1NotIn(List<String> values) {
            addCriterion("extr1 not in", values, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1Between(String value1, String value2) {
            addCriterion("extr1 between", value1, value2, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr1NotBetween(String value1, String value2) {
            addCriterion("extr1 not between", value1, value2, "extr1");
            return (Criteria) this;
        }

        public Criteria andExtr2IsNull() {
            addCriterion("extr2 is null");
            return (Criteria) this;
        }

        public Criteria andExtr2IsNotNull() {
            addCriterion("extr2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtr2EqualTo(String value) {
            addCriterion("extr2 =", value, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2NotEqualTo(String value) {
            addCriterion("extr2 <>", value, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2GreaterThan(String value) {
            addCriterion("extr2 >", value, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2GreaterThanOrEqualTo(String value) {
            addCriterion("extr2 >=", value, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2LessThan(String value) {
            addCriterion("extr2 <", value, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2LessThanOrEqualTo(String value) {
            addCriterion("extr2 <=", value, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2Like(String value) {
            addCriterion("extr2 like", value, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2NotLike(String value) {
            addCriterion("extr2 not like", value, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2In(List<String> values) {
            addCriterion("extr2 in", values, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2NotIn(List<String> values) {
            addCriterion("extr2 not in", values, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2Between(String value1, String value2) {
            addCriterion("extr2 between", value1, value2, "extr2");
            return (Criteria) this;
        }

        public Criteria andExtr2NotBetween(String value1, String value2) {
            addCriterion("extr2 not between", value1, value2, "extr2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}