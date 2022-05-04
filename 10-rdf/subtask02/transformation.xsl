<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xpath-default-namespace="http://www.iana.org/assignments">
    <xsl:output method="text" encoding="UTF-8" indent="no"/>

    <xsl:template match="/pet">
        @prefix foaf: &lt;http://xmlns.com/foaf/0.1#&gt; .
        @prefix vs: &lt;http://skrhak.cz/nswi145/&gt; .
        @prefix dbpedia-owl: &lt;http://dbpedia.org/ontology/&gt; .
        &lt;<xsl:value-of select="./id"/>&gt; a vs:Pet ;
        foaf:givenName &quot;<xsl:value-of select="./Name"/>&quot; ;
        dbpedia-owl:animal &quot;<xsl:value-of select="./Animal"/>&quot; ;
        vs:favouriteToy &quot;<xsl:value-of select="./favouriteToy"/>&quot; .    
    
   
    </xsl:template>
    <xsl:template match="text()"/>
   
</xsl:stylesheet>


<!-- https://www.easycodeforall.com/test-and-debug-xslt.html -->