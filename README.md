pentaho-smartbar-plugin
=======================

The SmartBar plugin will be comprised of the following components:

<ul>
	<li> REST endpoint to provide search results in json </li>
	<li> Client side search </li>
</ul>

Goals:

<ul>
	<li>Provide a search bar at the top of PUC interface</li>
	<li>Typing into search bar prepopulates a drop down list of results as the user types</li>
</ul>

Search results may include: 
<ul>
	<li>solution files in repository</li>
	<li>navigation items (e.g. "Create a new dashboard", "Manage data sources")</li>
	<li>links to documentation (infocenter, etc.)</li>
</ul>
	

Stretch goals:

<ul>
	<li>Hotkey activation for search popup and results navigation (e.g. Command-Space on Mac, or pressing Command key and typing to search start menu on Windows/Unity/Gnome)</li>
	<li>More robust semantic search engine (rules engine?)</li>
	<li>Installer</li>
</ul>

Questions:

<ul>
	<li>How to create standard biserver plugin</li>
	<li>How to make mantle behave the way we need (navigate to solution repository file when result clicked)</li>
	<li>How to add REST endpoints for search from plugin</li>
</ul>
	

To build and deploy plugin to your local biserver:

<ol>
	<li>edit build.properties</li>
	<li>set pentaho.dir to your local biserver-ee root path</li>
	<li>execute: ant clean resolve dist install</li>
</ol>


