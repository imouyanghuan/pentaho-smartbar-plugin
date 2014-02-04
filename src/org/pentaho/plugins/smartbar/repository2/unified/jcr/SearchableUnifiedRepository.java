package org.pentaho.plugins.smartbar.repository2.unified.jcr;

import org.pentaho.platform.api.locale.IPentahoLocale;
import org.pentaho.platform.api.repository2.unified.IRepositoryFileData;
import org.pentaho.platform.api.repository2.unified.IUnifiedRepository;
import org.pentaho.platform.api.repository2.unified.RepositoryFile;
import org.pentaho.platform.api.repository2.unified.RepositoryFileAce;
import org.pentaho.platform.api.repository2.unified.RepositoryFileAcl;
import org.pentaho.platform.api.repository2.unified.RepositoryFilePermission;
import org.pentaho.platform.api.repository2.unified.RepositoryFileTree;
import org.pentaho.platform.api.repository2.unified.VersionSummary;
import org.pentaho.platform.repository2.unified.DefaultUnifiedRepository;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * Created by pminutillo on 1/14/14.
 */
public class SearchableUnifiedRepository implements IUnifiedRepository {

    DefaultUnifiedRepository repository;

    @Override
    public List<RepositoryFileAce> getEffectiveAces(Serializable fileId) {
        return repository.getEffectiveAces(fileId);
    }

    @Override
    public List<RepositoryFileAce> getEffectiveAces(Serializable fileId, boolean forceEntriesInheriting) {
        return repository.getEffectiveAces(fileId, forceEntriesInheriting);
    }

    @Override
    public boolean hasAccess(String path, EnumSet<RepositoryFilePermission> permissions) {
        return repository.hasAccess(path, permissions);
    }

    @Override
    public RepositoryFile getFile(String path) {
        return repository.getFile(path);
    }

    @Override
    public RepositoryFile getFileById(Serializable fileId) {
        return repository.getFileById(fileId);
    }

    @Override
    public RepositoryFile getFile(String path, boolean loadMaps) {
        return repository.getFile(path, loadMaps);
    }

    @Override
    public RepositoryFile getFileById(Serializable fileId, boolean loadMaps) {
        return repository.getFileById(fileId, loadMaps);
    }

    @Override
    public RepositoryFile getFile(String path, IPentahoLocale locale) {
        return repository.getFile(path, locale);
    }

    @Override
    public RepositoryFile getFileById(Serializable fileId, IPentahoLocale locale) {
        return repository.getFileById(fileId, locale);
    }

    @Override
    public RepositoryFile getFile(String path, boolean loadLocaleMaps, IPentahoLocale locale) {
        return repository.getFile(path, loadLocaleMaps, locale);
    }

    @Override
    public RepositoryFile getFileById(Serializable fileId, boolean loadLocaleMaps, IPentahoLocale locale) {
        return repository.getFileById(fileId, loadLocaleMaps, locale);
    }

    @Override
    public RepositoryFile createFile(Serializable parentFolderId, RepositoryFile file, IRepositoryFileData data, String versionMessage) {
        return repository.createFile(parentFolderId, file, data, versionMessage);
    }

    @Override
    public RepositoryFile createFolder(Serializable parentFolderId, RepositoryFile file, String versionMessage) {
        return repository.createFolder(parentFolderId, file, versionMessage);
    }

    @Override
    public RepositoryFile createFile(Serializable parentFolderId, RepositoryFile file, IRepositoryFileData data, RepositoryFileAcl acl, String versionMessage) {
        return repository.createFile(parentFolderId, file, data, acl, versionMessage);
    }

    @Override
    public RepositoryFile createFolder(Serializable parentFolderId, RepositoryFile file, RepositoryFileAcl acl, String versionMessage) {
        return repository.createFolder(parentFolderId, file, acl, versionMessage);
    }

    @Override
    public <T extends IRepositoryFileData> T getDataForExecute(Serializable fileId, Class<T> dataClass) {
        return repository.getDataForExecute(fileId, dataClass);
    }

    @Override
    public <T extends IRepositoryFileData> T getDataAtVersionForExecute(Serializable fileId, Serializable versionId, Class<T> dataClass) {
        return repository.getDataAtVersionForExecute(fileId, versionId, dataClass);
    }

    @Override
    public <T extends IRepositoryFileData> T getDataForRead(Serializable fileId, Class<T> dataClass) {
        return repository.getDataForRead(fileId, dataClass);
    }

    @Override
    public <T extends IRepositoryFileData> T getDataAtVersionForRead(Serializable fileId, Serializable versionId, Class<T> dataClass) {
        return repository.getDataAtVersionForRead(fileId, versionId, dataClass);
    }

    @Override
    public <T extends IRepositoryFileData> List<T> getDataForReadInBatch(List<RepositoryFile> files, Class<T> dataClass) {
        return repository.getDataForReadInBatch(files, dataClass);
    }

    @Override
    public <T extends IRepositoryFileData> List<T> getDataForExecuteInBatch(List<RepositoryFile> files, Class<T> dataClass) {
        return repository.getDataForExecuteInBatch(files, dataClass);
    }

    @Override
    public List<RepositoryFile> getChildren(Serializable folderId) {
        return repository.getChildren(folderId);
    }

    @Override
    public List<RepositoryFile> getChildren(Serializable folderId, String filter) {
        return repository.getChildren(folderId, filter);
    }

    @Override
    public List<RepositoryFile> getChildren(Serializable folderId, String filter, Boolean showHiddenFiles) {
        return repository.getChildren(folderId, filter, showHiddenFiles);
    }

    @Override
    public RepositoryFile updateFile(RepositoryFile file, IRepositoryFileData data, String versionMessage) {
        return repository.updateFile(file, data, versionMessage);
    }

    @Override
    public void deleteFile(Serializable fileId, boolean permanent, String versionMessage) {
        repository.deleteFile(fileId, permanent, versionMessage);
    }

    @Override
    public void deleteFile(Serializable fileId, String versionMessage) {
        repository.deleteFile(fileId, versionMessage);
    }

    @Override
    public void deleteFileAtVersion(Serializable fileId, Serializable versionId) {
        repository.deleteFileAtVersion(fileId, versionId);
    }

    @Override
    public List<RepositoryFile> getDeletedFiles(String origParentFolderPath) {
        return repository.getDeletedFiles(origParentFolderPath);
    }

    @Override
    public List<RepositoryFile> getDeletedFiles(String origParentFolderPath, String filter) {
        return repository.getDeletedFiles(origParentFolderPath, filter);
    }

    @Override
    public List<RepositoryFile> getDeletedFiles() {
        return repository.getDeletedFiles();
    }

    @Override
    public void undeleteFile(Serializable fileId, String versionMessage) {
        repository.undeleteFile(fileId, versionMessage);
    }

    @Override
    public RepositoryFileAcl getAcl(Serializable fileId) {
        return repository.getAcl(fileId);
    }

    @Override
    public void lockFile(Serializable fileId, String message) {
        repository.lockFile(fileId, message);
    }

    @Override
    public void unlockFile(Serializable fileId) {
        repository.unlockFile(fileId);
    }

    @Override
    public VersionSummary getVersionSummary(Serializable fileId, Serializable versionId) {
        return repository.getVersionSummary(fileId, versionId);
    }

    @Override
    public List<VersionSummary> getVersionSummaryInBatch(List<RepositoryFile> files) {
        return repository.getVersionSummaryInBatch(files);
    }

    @Override
    public List<VersionSummary> getVersionSummaries(Serializable fileId) {
        return repository.getVersionSummaries(fileId);
    }

    @Override
    public RepositoryFile getFileAtVersion(Serializable fileId, Serializable versionId) {
        return repository.getFileAtVersion(fileId, versionId);
    }

    @Override
    public RepositoryFileAcl updateAcl(RepositoryFileAcl acl) {
        return repository.updateAcl(acl);
    }

    @Override
    public void moveFile(Serializable fileId, String destAbsPath, String versionMessage) {
        repository.moveFile(fileId, destAbsPath, versionMessage);
    }

    @Override
    public void copyFile(Serializable fileId, String destAbsPath, String versionMessage) {
        repository.copyFile(fileId, destAbsPath, versionMessage);
    }

    @Override
    public void restoreFileAtVersion(Serializable fileId, Serializable versionId, String versionMessage) {
        repository.restoreFileAtVersion(fileId, versionId, versionMessage);
    }

    @Override
    public boolean canUnlockFile(Serializable fileId) {
        return repository.canUnlockFile(fileId);
    }

    @Override
    public RepositoryFileTree getTree(String path, int depth, String filter, boolean showHidden) {
        return repository.getTree(path, depth, filter, showHidden);
    }

    @Override
    public List<RepositoryFile> getReferrers(Serializable fileId) {
        return repository.getReferrers(fileId);
    }

    @Override
    public void setFileMetadata(Serializable fileId, Map<String, Serializable> metadataMap) {
        repository.setFileMetadata(fileId, metadataMap);
    }

    @Override
    public Map<String, Serializable> getFileMetadata(Serializable fileId) {
        return repository.getFileMetadata(fileId);
    }

    @Override
    public List<Character> getReservedChars() {
        return repository.getReservedChars();
    }

    @Override
    public List<Locale> getAvailableLocalesForFileById(Serializable fileId) {
        return repository.getAvailableLocalesForFileById(fileId);
    }

    @Override
    public List<Locale> getAvailableLocalesForFileByPath(String relPath) {
        return repository.getAvailableLocalesForFileByPath(relPath);
    }

    @Override
    public List<Locale> getAvailableLocalesForFile(RepositoryFile repositoryFile) {
        return repository.getAvailableLocalesForFile(repositoryFile);
    }

    @Override
    public Properties getLocalePropertiesForFileById(Serializable fileId, String locale) {
        return repository.getLocalePropertiesForFileById(fileId, locale);
    }

    @Override
    public Properties getLocalePropertiesForFileByPath(String relPath, String locale) {
        return repository.getLocalePropertiesForFileByPath(relPath, locale);
    }

    @Override
    public Properties getLocalePropertiesForFile(RepositoryFile repositoryFile, String locale) {
        return repository.getLocalePropertiesForFile(repositoryFile, locale);
    }

    @Override
    public void setLocalePropertiesForFileById(Serializable fileId, String locale, Properties properties) {
        repository.setLocalePropertiesForFileById(fileId, locale, properties);
    }

    @Override
    public void setLocalePropertiesForFileByPath(String relPath, String locale, Properties properties) {
        repository.setLocalePropertiesForFileByPath(relPath, locale, properties);
    }

    @Override
    public void setLocalePropertiesForFile(RepositoryFile repositoryFile, String locale, Properties properties) {
        repository.setLocalePropertiesForFile(repositoryFile, locale, properties);
    }

    @Override
    public void deleteLocalePropertiesForFile(RepositoryFile repositoryFile, String locale) {
        repository.deleteLocalePropertiesForFile(repositoryFile, locale);
    }

    @Override
    public RepositoryFile updateFolder(RepositoryFile folder, String versionMessage) {
        return repository.updateFolder(folder, versionMessage);
    }
}
