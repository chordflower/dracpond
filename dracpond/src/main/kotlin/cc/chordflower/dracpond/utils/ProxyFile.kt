@file:Suppress("UNCHECKED_CAST")

package cc.chordflower.dracpond.utils

import java.io.File
import java.io.FileFilter
import java.io.FilenameFilter
import java.io.IOException
import java.net.URI
import java.nio.file.FileAlreadyExistsException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.FileTime
import java.nio.file.attribute.PosixFilePermission
import java.util.*

/**
 * Implements the file api using the given path instead, to allow for diferent filesystem implementations.
 */
class ProxyFile(filePath: Path) : File("/") {
  private val _filePath: Path = filePath.normalize()
  override fun canExecute(): Boolean {
    return Files.isExecutable(_filePath)
  }

  override fun canRead(): Boolean {
    return Files.isReadable(_filePath)
  }

  override fun canWrite(): Boolean {
    return Files.isWritable(_filePath)
  }

  override fun compareTo(other: File): Int {
    return _filePath.compareTo(other.toPath())
  }

  @Throws(IOException::class) override fun createNewFile(): Boolean {
    return try {
      Files.createFile(_filePath)
      true
    } catch(ex: FileAlreadyExistsException) {
      false
    }
  }

  override fun delete(): Boolean {
    return try {
      Files.delete(_filePath)
      true
    } catch(ex: IOException) {
      false
    }
  }

  override fun deleteOnExit() {
    delete()
  }

  override fun equals(other: Any?): Boolean {
    return if(other is File) {
      _filePath == other.toPath()
    } else false
  }

  override fun exists(): Boolean {
    return Files.exists(_filePath)
  }

  override fun getAbsoluteFile(): File {
    return ProxyFile(_filePath.toAbsolutePath())
  }

  override fun getAbsolutePath(): String {
    return _filePath.toAbsolutePath().toString()
  }

  override fun getCanonicalFile(): File {
    return ProxyFile(_filePath.toAbsolutePath().normalize())
  }

  override fun getCanonicalPath(): String {
    return _filePath.toAbsolutePath().normalize().toString()
  }

  override fun getFreeSpace(): Long {
    return 0L
  }

  override fun getName(): String {
    return _filePath.fileName.toString()
  }

  override fun getParent(): String {
    return _filePath.toAbsolutePath().normalize().parent.toString()
  }

  override fun getParentFile(): File {
    return ProxyFile(_filePath.toAbsolutePath().normalize().parent)
  }

  override fun getPath(): String {
    return _filePath.toString()
  }

  override fun getTotalSpace(): Long {
    return 0L
  }

  override fun getUsableSpace(): Long {
    return 0L
  }

  override fun hashCode(): Int {
    return _filePath.hashCode()
  }

  override fun isAbsolute(): Boolean {
    return _filePath.isAbsolute
  }

  override fun isDirectory(): Boolean {
    return Files.isDirectory(_filePath)
  }

  override fun isFile(): Boolean {
    return Files.isRegularFile(_filePath)
  }

  override fun isHidden(): Boolean {
    return try {
      Files.isHidden(_filePath)
    } catch(e: IOException) {
      false
    }
  }

  override fun lastModified(): Long {
    return try {
      Files.getLastModifiedTime(_filePath).toMillis()
    } catch(e: IOException) {
      0L
    }
  }

  override fun length(): Long {
    return try {
      Files.size(_filePath)
    } catch(e: IOException) {
      0L
    }
  }

  override fun list(): Array<String> {
    return try {
      Files.list(_filePath).map( { obj: Path -> obj.toString() } ).toArray( { arrayOf() } )
    } catch(e: IOException) {
      arrayOf()
    }
  }

  override fun list(filter: FilenameFilter): Array<String> {
    return try {
      Files.list(_filePath).filter({ path: Path -> filter.accept(this, path.fileName.toString()) }).map({ obj: Path -> obj.toString() }).toArray{ arrayOf() }
    } catch(e: IOException) {
      arrayOf()
    }
  }

  override fun listFiles(): Array<File> {
    return try {
      Files.list(_filePath).map({ filePath: Path -> ProxyFile(filePath) }).toArray( { arrayOf() } )
    } catch(e: IOException) {
      arrayOf()
    }
  }

  override fun listFiles(filter: FileFilter): Array<File> {
    return try {
      Files.list(_filePath).map { filePath: Path -> ProxyFile(filePath) }.filter { pathname: ProxyFile? -> filter.accept(pathname) }.toArray( { arrayOf() } )
    } catch(e: IOException) {
      arrayOf()
    }
  }

  override fun listFiles(filter: FilenameFilter): Array<File> {
    return try {
      Files.list(_filePath).filter { path: Path -> filter.accept(this, path.fileName.toString()) }.map { filePath: Path -> ProxyFile(filePath) }.toArray( { arrayOf() } )
    } catch(e: IOException) {
      arrayOf()
    }
  }

  override fun mkdir(): Boolean {
    return try {
      Files.createDirectory(_filePath)
      true
    } catch(e: IOException) {
      false
    }
  }

  override fun mkdirs(): Boolean {
    return try {
      Files.createDirectories(_filePath) != null
    } catch(e: IOException) {
      false
    }
  }

  override fun renameTo(dest: File): Boolean {
    return try {
      Files.move(_filePath, dest.toPath())
      true
    } catch(e: IOException) {
      false
    }
  }

  override fun setExecutable(executable: Boolean): Boolean {
    return this.setExecutable(executable, true)
  }

  override fun setExecutable(executable: Boolean, ownerOnly: Boolean): Boolean {
    return try {
      val permissions: MutableSet<PosixFilePermission> = HashSet(Files.getAttribute(_filePath, "posix.permissions") as Set<PosixFilePermission>)
      if(executable) {
        val newPermissions = if(ownerOnly) EnumSet.of(PosixFilePermission.OWNER_EXECUTE) else EnumSet.of(PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_EXECUTE, PosixFilePermission.OWNER_EXECUTE)
        permissions.addAll(newPermissions)
      } else {
        permissions.remove(PosixFilePermission.OWNER_EXECUTE)
        if(!ownerOnly) {
          permissions.remove(PosixFilePermission.GROUP_EXECUTE)
          permissions.remove(PosixFilePermission.OTHERS_EXECUTE)
        }
      }
      Files.setAttribute(_filePath, "posix.permissions", permissions)
      true
    } catch(e: IOException) {
      false
    }
  }

  override fun setLastModified(time: Long): Boolean {
    return try {
      Files.setLastModifiedTime(_filePath, FileTime.fromMillis(time))
      true
    } catch(e: IOException) {
      false
    }
  }

  override fun setReadable(readable: Boolean): Boolean {
    return this.setReadable(readable, true)
  }

  override fun setReadable(readable: Boolean, ownerOnly: Boolean): Boolean {
    return try {
      val permissions: MutableSet<PosixFilePermission> = HashSet(Files.getAttribute(_filePath, "posix.permissions") as Set<PosixFilePermission>)
      if(readable) {
        val newPermissions = if(ownerOnly) EnumSet.of(PosixFilePermission.OWNER_READ) else EnumSet.of(PosixFilePermission.GROUP_READ, PosixFilePermission.OTHERS_READ, PosixFilePermission.OWNER_READ)
        permissions.addAll(newPermissions)
      } else {
        permissions.remove(PosixFilePermission.OWNER_READ)
        if(!ownerOnly) {
          permissions.remove(PosixFilePermission.GROUP_READ)
          permissions.remove(PosixFilePermission.OTHERS_READ)
        }
      }
      Files.setAttribute(_filePath, "posix.permissions", permissions)
      true
    } catch(e: IOException) {
      try {
        Files.setAttribute(_filePath, "dos.readonly", readable)
        true
      } catch(e1: IOException) {
        false
      }
    }
  }

  override fun setReadOnly(): Boolean {
    return try {
      val newPermissions: Set<PosixFilePermission> = EnumSet.of(PosixFilePermission.GROUP_READ, PosixFilePermission.OTHERS_READ, PosixFilePermission.OWNER_READ)
      val permissions: MutableSet<PosixFilePermission> = HashSet(Files.getAttribute(_filePath, "posix.permissions") as Set<PosixFilePermission>)
      permissions.addAll(newPermissions)
      Files.setAttribute(_filePath, "posix.permissions", permissions)
      true
    } catch(e: IOException) {
      try {
        Files.setAttribute(_filePath, "dos.readonly", java.lang.Boolean.TRUE)
        true
      } catch(e1: IOException) {
        false
      }
    }
  }

  override fun setWritable(writable: Boolean): Boolean {
    return this.setWritable(writable, true)
  }

  override fun setWritable(writable: Boolean, ownerOnly: Boolean): Boolean {
    return try {
      val permissions: MutableSet<PosixFilePermission> = HashSet(Files.getAttribute(_filePath, "posix.permissions") as Set<PosixFilePermission>)
      if(writable) {
        val newPermissions = if(ownerOnly) EnumSet.of(PosixFilePermission.OWNER_WRITE) else EnumSet.of(PosixFilePermission.GROUP_WRITE, PosixFilePermission.OTHERS_WRITE, PosixFilePermission.OWNER_WRITE)
        permissions.addAll(newPermissions)
      } else {
        permissions.remove(PosixFilePermission.OWNER_WRITE)
        if(!ownerOnly) {
          permissions.remove(PosixFilePermission.GROUP_WRITE)
          permissions.remove(PosixFilePermission.OTHERS_WRITE)
        }
      }
      Files.setAttribute(_filePath, "posix.permissions", permissions)
      true
    } catch(e: IOException) {
      false
    }
  }

  override fun toPath(): Path {
    return _filePath
  }

  override fun toString(): String {
    return _filePath.toString()
  }

  override fun toURI(): URI {
    return _filePath.toUri()
  }

  companion object {
    private const val serialVersionUID = 1L
  }

}
