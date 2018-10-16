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

package com.liferay.symposium.citytour.uad.uad.anonymizer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import com.liferay.symposium.citytour.uad.uad.constants.CitytourUADConstants;
import com.liferay.symposium.citytours.promociones.model.Promocion;
import com.liferay.symposium.citytours.promociones.service.PromocionLocalService;

import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the promocion UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link PromocionUADAnonymizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BasePromocionUADAnonymizer
	extends DynamicQueryUADAnonymizer<Promocion> {
	@Override
	public void autoAnonymize(Promocion promocion, long userId,
		User anonymousUser) throws PortalException {
		if (promocion.getUserId() == userId) {
			promocion.setUserId(anonymousUser.getUserId());
			promocion.setUserName(anonymousUser.getFullName());
		}

		promocionLocalService.updatePromocion(promocion);
	}

	@Override
	public void delete(Promocion promocion) throws PortalException {
		promocionLocalService.deletePromocion(promocion);
	}

	@Override
	public Class<Promocion> getTypeClass() {
		return Promocion.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return promocionLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return CitytourUADConstants.USER_ID_FIELD_NAMES_PROMOCION;
	}

	@Reference
	protected PromocionLocalService promocionLocalService;
}