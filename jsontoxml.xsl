<xsl:stylesheet version="3.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output indent="yes" />
	<xsl:strip-space elements="*" />
	<xsl:param name="jsonText" />



	<xsl:template name="init">
		<xsl:apply-templates
			select="json-to-xml($jsonText)" />
	</xsl:template>

	<xsl:template match="*[@key]">
		<xsl:element name="{@key}">
			<xsl:apply-templates />
		</xsl:element>
	</xsl:template>
	<xsl:template match="array">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="array[@key]">
		<xsl:element name="{../@key}">
			<xsl:apply-templates />
		</xsl:element>
	</xsl:template>



</xsl:stylesheet>