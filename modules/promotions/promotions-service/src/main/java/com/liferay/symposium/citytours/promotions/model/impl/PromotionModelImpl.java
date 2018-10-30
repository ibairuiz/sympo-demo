/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.symposium.citytours.promotions.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.liferay.symposium.citytours.promotions.model.Promotion;
import com.liferay.symposium.citytours.promotions.model.PromotionModel;
import com.liferay.symposium.citytours.promotions.model.PromotionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Promotion service. Represents a row in the &quot;Citytours_Promotion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PromotionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PromotionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PromotionImpl
 * @see Promotion
 * @see PromotionModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PromotionModelImpl extends BaseModelImpl<Promotion>
	implements PromotionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a promotion model instance should use the {@link Promotion} interface instead.
	 */
	public static final String TABLE_NAME = "Citytours_Promotion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "promotionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "description", Types.VARCHAR },
			{ "price", Types.DOUBLE },
			{ "destinationCity", Types.VARCHAR },
			{ "offereeFirstName", Types.VARCHAR },
			{ "offereeLastName", Types.VARCHAR },
			{ "offereeIdNumber", Types.VARCHAR },
			{ "offereeTelephone", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("promotionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("price", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("destinationCity", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("offereeFirstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("offereeLastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("offereeIdNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("offereeTelephone", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Citytours_Promotion (uuid_ VARCHAR(75) null,promotionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,description VARCHAR(75) null,price DOUBLE,destinationCity VARCHAR(75) null,offereeFirstName VARCHAR(75) null,offereeLastName VARCHAR(75) null,offereeIdNumber VARCHAR(75) null,offereeTelephone VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Citytours_Promotion";
	public static final String ORDER_BY_JPQL = " ORDER BY promotion.description ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Citytours_Promotion.description ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.symposium.citytours.promotions.citytours.promotions.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.symposium.citytours.promotions.model.Promotion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.symposium.citytours.promotions.citytours.promotions.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.symposium.citytours.promotions.model.Promotion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.symposium.citytours.promotions.citytours.promotions.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.symposium.citytours.promotions.model.Promotion"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long DESCRIPTION_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long PROMOTIONID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Promotion toModel(PromotionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Promotion model = new PromotionImpl();

		model.setUuid(soapModel.getUuid());
		model.setPromotionId(soapModel.getPromotionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDescription(soapModel.getDescription());
		model.setPrice(soapModel.getPrice());
		model.setDestinationCity(soapModel.getDestinationCity());
		model.setOffereeFirstName(soapModel.getOffereeFirstName());
		model.setOffereeLastName(soapModel.getOffereeLastName());
		model.setOffereeIdNumber(soapModel.getOffereeIdNumber());
		model.setOffereeTelephone(soapModel.getOffereeTelephone());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Promotion> toModels(PromotionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Promotion> models = new ArrayList<Promotion>(soapModels.length);

		for (PromotionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.symposium.citytours.promotions.citytours.promotions.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.symposium.citytours.promotions.model.Promotion"));

	public PromotionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _promotionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPromotionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _promotionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Promotion.class;
	}

	@Override
	public String getModelClassName() {
		return Promotion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("promotionId", getPromotionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("price", getPrice());
		attributes.put("destinationCity", getDestinationCity());
		attributes.put("offereeFirstName", getOffereeFirstName());
		attributes.put("offereeLastName", getOffereeLastName());
		attributes.put("offereeIdNumber", getOffereeIdNumber());
		attributes.put("offereeTelephone", getOffereeTelephone());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long promotionId = (Long)attributes.get("promotionId");

		if (promotionId != null) {
			setPromotionId(promotionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String destinationCity = (String)attributes.get("destinationCity");

		if (destinationCity != null) {
			setDestinationCity(destinationCity);
		}

		String offereeFirstName = (String)attributes.get("offereeFirstName");

		if (offereeFirstName != null) {
			setOffereeFirstName(offereeFirstName);
		}

		String offereeLastName = (String)attributes.get("offereeLastName");

		if (offereeLastName != null) {
			setOffereeLastName(offereeLastName);
		}

		String offereeIdNumber = (String)attributes.get("offereeIdNumber");

		if (offereeIdNumber != null) {
			setOffereeIdNumber(offereeIdNumber);
		}

		String offereeTelephone = (String)attributes.get("offereeTelephone");

		if (offereeTelephone != null) {
			setOffereeTelephone(offereeTelephone);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getPromotionId() {
		return _promotionId;
	}

	@Override
	public void setPromotionId(long promotionId) {
		_columnBitmask |= PROMOTIONID_COLUMN_BITMASK;

		if (!_setOriginalPromotionId) {
			_setOriginalPromotionId = true;

			_originalPromotionId = _promotionId;
		}

		_promotionId = promotionId;
	}

	public long getOriginalPromotionId() {
		return _originalPromotionId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_columnBitmask = -1L;

		if (_originalDescription == null) {
			_originalDescription = _description;
		}

		_description = description;
	}

	public String getOriginalDescription() {
		return GetterUtil.getString(_originalDescription);
	}

	@JSON
	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;
	}

	@JSON
	@Override
	public String getDestinationCity() {
		if (_destinationCity == null) {
			return "";
		}
		else {
			return _destinationCity;
		}
	}

	@Override
	public void setDestinationCity(String destinationCity) {
		_destinationCity = destinationCity;
	}

	@JSON
	@Override
	public String getOffereeFirstName() {
		if (_offereeFirstName == null) {
			return "";
		}
		else {
			return _offereeFirstName;
		}
	}

	@Override
	public void setOffereeFirstName(String offereeFirstName) {
		_offereeFirstName = offereeFirstName;
	}

	@JSON
	@Override
	public String getOffereeLastName() {
		if (_offereeLastName == null) {
			return "";
		}
		else {
			return _offereeLastName;
		}
	}

	@Override
	public void setOffereeLastName(String offereeLastName) {
		_offereeLastName = offereeLastName;
	}

	@JSON
	@Override
	public String getOffereeIdNumber() {
		if (_offereeIdNumber == null) {
			return "";
		}
		else {
			return _offereeIdNumber;
		}
	}

	@Override
	public void setOffereeIdNumber(String offereeIdNumber) {
		_offereeIdNumber = offereeIdNumber;
	}

	@JSON
	@Override
	public String getOffereeTelephone() {
		if (_offereeTelephone == null) {
			return "";
		}
		else {
			return _offereeTelephone;
		}
	}

	@Override
	public void setOffereeTelephone(String offereeTelephone) {
		_offereeTelephone = offereeTelephone;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Promotion.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Promotion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Promotion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Promotion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PromotionImpl promotionImpl = new PromotionImpl();

		promotionImpl.setUuid(getUuid());
		promotionImpl.setPromotionId(getPromotionId());
		promotionImpl.setGroupId(getGroupId());
		promotionImpl.setCompanyId(getCompanyId());
		promotionImpl.setUserId(getUserId());
		promotionImpl.setUserName(getUserName());
		promotionImpl.setCreateDate(getCreateDate());
		promotionImpl.setModifiedDate(getModifiedDate());
		promotionImpl.setDescription(getDescription());
		promotionImpl.setPrice(getPrice());
		promotionImpl.setDestinationCity(getDestinationCity());
		promotionImpl.setOffereeFirstName(getOffereeFirstName());
		promotionImpl.setOffereeLastName(getOffereeLastName());
		promotionImpl.setOffereeIdNumber(getOffereeIdNumber());
		promotionImpl.setOffereeTelephone(getOffereeTelephone());

		promotionImpl.resetOriginalValues();

		return promotionImpl;
	}

	@Override
	public int compareTo(Promotion promotion) {
		int value = 0;

		value = getDescription().compareTo(promotion.getDescription());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Promotion)) {
			return false;
		}

		Promotion promotion = (Promotion)obj;

		long primaryKey = promotion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PromotionModelImpl promotionModelImpl = this;

		promotionModelImpl._originalUuid = promotionModelImpl._uuid;

		promotionModelImpl._originalPromotionId = promotionModelImpl._promotionId;

		promotionModelImpl._setOriginalPromotionId = false;

		promotionModelImpl._originalGroupId = promotionModelImpl._groupId;

		promotionModelImpl._setOriginalGroupId = false;

		promotionModelImpl._originalCompanyId = promotionModelImpl._companyId;

		promotionModelImpl._setOriginalCompanyId = false;

		promotionModelImpl._setModifiedDate = false;

		promotionModelImpl._originalDescription = promotionModelImpl._description;

		promotionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Promotion> toCacheModel() {
		PromotionCacheModel promotionCacheModel = new PromotionCacheModel();

		promotionCacheModel.uuid = getUuid();

		String uuid = promotionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			promotionCacheModel.uuid = null;
		}

		promotionCacheModel.promotionId = getPromotionId();

		promotionCacheModel.groupId = getGroupId();

		promotionCacheModel.companyId = getCompanyId();

		promotionCacheModel.userId = getUserId();

		promotionCacheModel.userName = getUserName();

		String userName = promotionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			promotionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			promotionCacheModel.createDate = createDate.getTime();
		}
		else {
			promotionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			promotionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			promotionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		promotionCacheModel.description = getDescription();

		String description = promotionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			promotionCacheModel.description = null;
		}

		promotionCacheModel.price = getPrice();

		promotionCacheModel.destinationCity = getDestinationCity();

		String destinationCity = promotionCacheModel.destinationCity;

		if ((destinationCity != null) && (destinationCity.length() == 0)) {
			promotionCacheModel.destinationCity = null;
		}

		promotionCacheModel.offereeFirstName = getOffereeFirstName();

		String offereeFirstName = promotionCacheModel.offereeFirstName;

		if ((offereeFirstName != null) && (offereeFirstName.length() == 0)) {
			promotionCacheModel.offereeFirstName = null;
		}

		promotionCacheModel.offereeLastName = getOffereeLastName();

		String offereeLastName = promotionCacheModel.offereeLastName;

		if ((offereeLastName != null) && (offereeLastName.length() == 0)) {
			promotionCacheModel.offereeLastName = null;
		}

		promotionCacheModel.offereeIdNumber = getOffereeIdNumber();

		String offereeIdNumber = promotionCacheModel.offereeIdNumber;

		if ((offereeIdNumber != null) && (offereeIdNumber.length() == 0)) {
			promotionCacheModel.offereeIdNumber = null;
		}

		promotionCacheModel.offereeTelephone = getOffereeTelephone();

		String offereeTelephone = promotionCacheModel.offereeTelephone;

		if ((offereeTelephone != null) && (offereeTelephone.length() == 0)) {
			promotionCacheModel.offereeTelephone = null;
		}

		return promotionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", promotionId=");
		sb.append(getPromotionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", destinationCity=");
		sb.append(getDestinationCity());
		sb.append(", offereeFirstName=");
		sb.append(getOffereeFirstName());
		sb.append(", offereeLastName=");
		sb.append(getOffereeLastName());
		sb.append(", offereeIdNumber=");
		sb.append(getOffereeIdNumber());
		sb.append(", offereeTelephone=");
		sb.append(getOffereeTelephone());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.liferay.symposium.citytours.promotions.model.Promotion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotionId</column-name><column-value><![CDATA[");
		sb.append(getPromotionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>destinationCity</column-name><column-value><![CDATA[");
		sb.append(getDestinationCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>offereeFirstName</column-name><column-value><![CDATA[");
		sb.append(getOffereeFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>offereeLastName</column-name><column-value><![CDATA[");
		sb.append(getOffereeLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>offereeIdNumber</column-name><column-value><![CDATA[");
		sb.append(getOffereeIdNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>offereeTelephone</column-name><column-value><![CDATA[");
		sb.append(getOffereeTelephone());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Promotion.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Promotion.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _promotionId;
	private long _originalPromotionId;
	private boolean _setOriginalPromotionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _description;
	private String _originalDescription;
	private double _price;
	private String _destinationCity;
	private String _offereeFirstName;
	private String _offereeLastName;
	private String _offereeIdNumber;
	private String _offereeTelephone;
	private long _columnBitmask;
	private Promotion _escapedModel;
}