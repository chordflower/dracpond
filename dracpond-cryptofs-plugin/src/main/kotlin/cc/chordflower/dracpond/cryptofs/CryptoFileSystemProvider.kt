package cc.chordflower.dracpond.cryptofs

import java.io.IOException
import java.net.URI
import java.nio.channels.SeekableByteChannel
import java.nio.file.AccessMode
import java.nio.file.CopyOption
import java.nio.file.DirectoryStream
import java.nio.file.FileStore
import java.nio.file.FileSystem
import java.nio.file.LinkOption
import java.nio.file.OpenOption
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileAttribute
import java.nio.file.attribute.FileAttributeView
import java.nio.file.spi.FileSystemProvider

class CryptoFileSystemProvider : FileSystemProvider() {
  override fun getScheme(): String {
    return ""
  }

  @Throws(IOException::class)
  override fun newFileSystem(uri: URI, env: Map<String?, *>?): FileSystem {
    throw IllegalArgumentException()
  }

  override fun getFileSystem(uri: URI): FileSystem {
    throw IllegalArgumentException()
  }

  override fun getPath(uri: URI): Path {
    throw IllegalArgumentException()
  }

  @Throws(IOException::class)
  override fun newByteChannel(path: Path, options: Set<OpenOption?>, vararg attrs: FileAttribute<*>?): SeekableByteChannel {
    throw IllegalArgumentException()
  }

  @Throws(IOException::class)
  override fun newDirectoryStream(dir: Path, filter: DirectoryStream.Filter<in Path>): DirectoryStream<Path> {
    throw IllegalArgumentException()
  }

  @Throws(IOException::class) override fun createDirectory(dir: Path, vararg attrs: FileAttribute<*>?) {}
  @Throws(IOException::class) override fun delete(path: Path) {}
  @Throws(IOException::class) override fun copy(source: Path, target: Path, vararg options: CopyOption) {}
  @Throws(IOException::class) override fun move(source: Path, target: Path, vararg options: CopyOption) {}
  @Throws(IOException::class) override fun isSameFile(path: Path, path2: Path): Boolean {
    return false
  }

  @Throws(IOException::class) override fun isHidden(path: Path): Boolean {
    return false
  }

  @Throws(IOException::class) override fun getFileStore(path: Path): FileStore {
    throw IllegalArgumentException()
  }

  @Throws(IOException::class) override fun checkAccess(path: Path, vararg modes: AccessMode) {}

  override fun <V : FileAttributeView?> getFileAttributeView(path: Path, type: Class<V>, vararg options: LinkOption): V {
    throw IllegalArgumentException()
  }

  @Throws(IOException::class) override fun <A : BasicFileAttributes?> readAttributes(path: Path, type: Class<A>, vararg options: LinkOption): A {
    throw IllegalArgumentException()
  }

  @Throws(IOException::class) override fun readAttributes(path: Path, attributes: String, vararg options: LinkOption): Map<String, Any> {
    throw IllegalArgumentException()
  }

  @Throws(IOException::class) override fun setAttribute(path: Path, attribute: String, value: Any, vararg options: LinkOption) {}
}
