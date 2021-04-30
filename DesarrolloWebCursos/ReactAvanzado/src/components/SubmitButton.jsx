import React from 'react'

import { Button } from '../assets/styles/components/SubmitButton'

import PropTypes from 'prop-types'

export const SubmitButton = ({ children, disabled, onClick }) => {
	return <Button disabled={disabled} onClick={onClick}>{children}</Button>
}

SubmitButton.propTypes = {
	disabled: PropTypes.bool,
	onClick: PropTypes.func,
	children: PropTypes.node.isRequired
}
