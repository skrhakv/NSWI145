<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:ns2="http://soap02/"
    xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"
    xpath-default-namespace="http://www.iana.org/assignments">
    <xsl:output method="text" encoding="UTF-8" indent="no"/>
    <xsl:variable name="prefix">https://example.org/iana/media-types/</xsl:variable>

    <xsl:template match="/">
@prefix rdf: &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
@prefix dcterms: &lt;http://purl.org/dc/terms/&gt; .
@prefix ns2: &lt;http://soap02/&gt; .
    <xsl:for-each select="/S:Envelope/S:Body/ns2:GetBalanceResponse"> 
    &lt;result&gt; a dcterms:MediaType ;
        ns2:return <xsl:value-of select="./return"/> .
    </xsl:for-each>
    </xsl:template>
   
    <xsl:template match="text()"/>
   
</xsl:stylesheet>
