package com.finalproject.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SetAttribute<Role, Permission> permissions;
	public static volatile SingularAttribute<Role, Organization> organization;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, Integer> id;
	public static volatile SetAttribute<Role, User> users;

	public static final String PERMISSIONS = "permissions";
	public static final String ORGANIZATION = "organization";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String USERS = "users";

}

